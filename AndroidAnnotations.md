#Android Annotations Guide

##1) All classes get compiled to _.class
```
MyActivity.class -> MyActivity_.class
```
**Will have to update the intents and manifest likewise**

##2) Views injected *after* onCreate
```
use @AfterViews
```
####NPE will be caused if referenced in onCreate

##3) Use the docs
```
https://github.com/androidannotations/androidannotations/wiki
```
##4) How to convert Activity to Fragments
```
https://github.com/OmniDebt/OmniDebt-Android/wiki/Convert-Activity-to-Fragment
```
##5) Android anotations for Fragments
```
Bind layout to fragment 
          @EFragment( R.layout.<Your Layout Name> )
All classes get compiled to _.class
        Tab2_Activity tab2 = new Tab2_Activity_();
```
