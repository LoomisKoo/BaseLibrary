#BaseLibrary
##相关开源库
- //阿里巴巴扩展列表 vlayotu   
**compile 'com.alibaba.android:vlayout:1.2.6'**

- //okhttp3  
**compile 'com.squareup.okhttp3:logging-interceptor:3.10.0'**
**compile 'com.squareup.okhttp3:okhttp:3.10.0'**

- //butterknife  
**compile 'com.jakewharton:butterknife:10.0.0'**
**compile 'com.jakewharton:butterknife-compiler:10.0.0'**

- //fastJson  
**compile 'com.alibaba:fastjson:1.2.51'**
- //加载动画
**compile 'com.zyao89:zloading:1.2.0'**

- //各种方法类集合   
**compile 'com.blankj:utilcode:1.13.5'**
- //阿里Arouter  
**compile 'com.alibaba:arouter-api:1.4.1'**   
**annotationProcessor 'com.alibaba:arouter-compiler:1.2.2'**

- //SmartRefreshLayout  
**compile 'com.scwang.smartrefresh:SmartRefreshLayout:1.0.4-7'**

- //侧滑recyclerview  
**compile 'com.github.LoomisKoo:SwipeRecyclerview:1.0.1'**

- //图片框架  glide  
**compile 'com.github.bumptech.glide:glide:4.8.0'**  
**compile 'jp.wasabeef:glide-transformations:4.0.0'**

- //RecycleView动画库  
**compile 'jp.wasabeef:recyclerview-animators:2.2.3'**  
**compile 'com.google.android.material:material:1.1.0-alpha05'**

- //滑动返回  
**compile 'cn.bingoogolapple:bga-swipebacklayout:1.2.0@aar'**

**依赖本库后，以上开源库可以直接调用**

##设计初衷
平时做些小项目，很多库都是公用的，每次都引入和配置比较麻烦，基于偷懒原则，就把一些常用的库集成到一个module中再发布出来供其他项目引用。

##使用
在项目级的build.gradle的根节点添加以下内容

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
然后再项目级的build.gradle根节点添加以下内容

```
dependencies {
    implementation 'com.github.LoomisKoo:BaseLibrary:1.1.1'
 }
```

##Demo
demo在主module中，暂时只演示了部分，后续完善。 

##其他
###各个库的使用方法
往后有时间会不全各库的使用说明文档，或者使用者上网找到相应的库的使用教程

###联系方式
- 邮箱：286305974@qq.com （同QQ）
- 微信：chocokoo
若有问题或者建议可通过以上两种方式联系我，谢谢大家。