package com.loomis.koo.library.manager;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import androidx.fragment.app.Fragment;

/**
 * @ProjectName: Test
 * @Package: com.example.administrator.test.manager
 * @ClassName: FragmentUserVisibleManager
 * @Description: java类作用描述 嵌套viewpager-fragment时，Fragment的getUserVisibleHint()方法并不能准确反映fragment是否显示状态，该类可以准确反映fragment显示/隐藏状态
 * @Author: koo
 * @CreateDate: 2019/1/24 10:08 AM
 * @UpdateUser:
 * @UpdateDate: 2019/1/24 10:08 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FragmentUserVisibleManager {
    private static final String                      TAG     = "UserVisibleManager";
    public static        boolean                     isDebug = true;
    @SuppressWarnings("FieldCanBeLocal")
    private              String                      fragmentName;
    private              boolean                     waitingShowToUser;
    private              Fragment                    fragment;
    private              UserVisibleCallback         userVisibleCallback;
    private              List<OnUserVisibleListener> userVisibleListenerList;

    public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public FragmentUserVisibleManager(Fragment fragment, UserVisibleCallback userVisibleCallback) {
        this.fragment = fragment;
        this.userVisibleCallback = userVisibleCallback;
        //noinspection ConstantConditions
        this.fragmentName = isDebug ? fragment.getClass()
                                            .getSimpleName() : null;
    }

    public void activityCreated() {
        if (isDebug) {
            Log.d(TAG, fragmentName + ": activityCreated, userVisibleHint=" + fragment.getUserVisibleHint());
        }
        if (fragment.getUserVisibleHint()) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null && !parentFragment.getUserVisibleHint()) {
                if (isDebug) {
                    Log.d(TAG, fragmentName + ": activityCreated, parent " + parentFragment.getClass()
                                                                                           .getSimpleName() + " is hidden, therefore hidden self");
                }
                userVisibleCallback.setWaitingShowToUser(true);
                userVisibleCallback.callSuperSetUserVisibleHint(false);
            }
        }
    }

    public void resume() {
        if (isDebug) {
            Log.d(TAG, fragmentName + ": resume, userVisibleHint=" + fragment.getUserVisibleHint());
        }
        if (fragment.getUserVisibleHint()) {
            userVisibleCallback.onVisibleToUserChanged(true, true);
            callbackListener(true, true);
            if (isDebug) {
                Log.i(TAG, fragmentName + ": visibleToUser on resume");
            }
        }
    }

    public void pause() {
        if (isDebug) {
            Log.d(TAG, fragmentName + ": pause, userVisibleHint=" + fragment.getUserVisibleHint());
        }
        if (fragment.getUserVisibleHint()) {
            userVisibleCallback.onVisibleToUserChanged(false, true);
            callbackListener(false, true);
            if (isDebug) {
                Log.w(TAG, fragmentName + ": hiddenToUser on pause");
            }
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        Fragment parentFragment = fragment.getParentFragment();
        if (isDebug) {
            String parent;
            if (parentFragment != null) {
                parent = "parent " + parentFragment.getClass()
                                                   .getSimpleName() + " userVisibleHint=" + parentFragment.getUserVisibleHint();
            }
            else {
                parent = "parent is null";
            }
            Log.d(TAG, fragmentName + ": setUserVisibleHint, userVisibleHint=" + isVisibleToUser + ", " + (fragment.isResumed() ? "resume" : "pause") + ", " + parent);
        }

        // 父Fragment还没显示，你着什么急
        if (isVisibleToUser) {
            if (parentFragment != null && !parentFragment.getUserVisibleHint()) {
                if (isDebug) {
                    Log.d(TAG, fragmentName + ": setUserVisibleHint, parent " + parentFragment.getClass()
                                                                                              .getSimpleName() + " is hidden, therefore hidden self");
                }
                userVisibleCallback.setWaitingShowToUser(true);
                userVisibleCallback.callSuperSetUserVisibleHint(false);
                return;
            }
        }

        if (fragment.isResumed()) {
            userVisibleCallback.onVisibleToUserChanged(isVisibleToUser, false);
            callbackListener(isVisibleToUser, false);
            if (isDebug) {
                if (isVisibleToUser) {
                    Log.i(TAG, fragmentName + ": visibleToUser on setUserVisibleHint");
                }
                else {
                    Log.w(TAG, fragmentName + ": hiddenToUser on setUserVisibleHint");
                }
            }
        }

        if (fragment.getActivity() != null) {
            List<Fragment> childFragmentList = fragment.getChildFragmentManager()
                                                       .getFragments();
            if (isVisibleToUser) {
                // 显示待显示的子Fragment
                if (childFragmentList != null && childFragmentList.size() > 0) {
                    for (Fragment childFragment : childFragmentList) {
                        if (childFragment instanceof UserVisibleCallback) {
                            UserVisibleCallback userVisibleCallback = (UserVisibleCallback) childFragment;
                            if (userVisibleCallback.isWaitingShowToUser()) {
                                if (isDebug) {
                                    Log.d(TAG, fragmentName + ": setUserVisibleHint, show child " + childFragment.getClass()
                                                                                                                 .getSimpleName());
                                }
                                userVisibleCallback.setWaitingShowToUser(false);
                                childFragment.setUserVisibleHint(true);
                            }
                        }
                    }
                }
            }
            else {
                // 隐藏正在显示的子Fragment
                if (childFragmentList != null && childFragmentList.size() > 0) {
                    for (Fragment childFragment : childFragmentList) {
                        if (childFragment instanceof UserVisibleCallback) {
                            UserVisibleCallback userVisibleCallback = (UserVisibleCallback) childFragment;
                            if (childFragment.getUserVisibleHint()) {
                                if (isDebug) {
                                    Log.d(TAG, fragmentName + ": setUserVisibleHint, hidden child " + childFragment.getClass()
                                                                                                                   .getSimpleName());
                                }
                                userVisibleCallback.setWaitingShowToUser(true);
                                childFragment.setUserVisibleHint(false);
                            }
                        }
                    }
                }
            }
        }
    }

    private void callbackListener(boolean isVisibleToUser, boolean invokeInResumeOrPause) {
        if (userVisibleListenerList != null && userVisibleListenerList.size() > 0) {
            for (OnUserVisibleListener listener : userVisibleListenerList) {
                listener.onVisibleToUserChanged(isVisibleToUser, invokeInResumeOrPause);
            }
        }
    }

    /**
     * 当前Fragment是否对用户可见
     */
    @SuppressWarnings("unused")
    public boolean isVisibleToUser() {
        return fragment.isResumed() && fragment.getUserVisibleHint();
    }

    public boolean isWaitingShowToUser() {
        return waitingShowToUser;
    }

    public void setWaitingShowToUser(boolean waitingShowToUser) {
        this.waitingShowToUser = waitingShowToUser;
    }

    public void addOnUserVisibleListener(OnUserVisibleListener listener) {
        if (listener != null) {
            if (userVisibleListenerList == null) {
                userVisibleListenerList = new LinkedList<>();
            }
            userVisibleListenerList.add(listener);
        }
    }

    public void removeOnUserVisibleListener(OnUserVisibleListener listener) {
        if (listener != null && userVisibleListenerList != null) {
            userVisibleListenerList.remove(listener);
        }
    }

    public interface UserVisibleCallback {
        boolean isWaitingShowToUser();

        void setWaitingShowToUser(boolean waitingShowToUser);

        boolean isVisibleToUser();

        void callSuperSetUserVisibleHint(boolean isVisibleToUser);

        void onVisibleToUserChanged(boolean isVisibleToUser, boolean invokeInResumeOrPause);
    }

    public interface OnUserVisibleListener {
        void onVisibleToUserChanged(boolean isVisibleToUser, boolean invokeInResumeOrPause);
    }
}