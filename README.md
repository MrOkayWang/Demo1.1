# Demo1.1
学习Android
Fragment
Fragment有自己的生命周期

Fragmen依赖于Activity

Fragement通过getActivity()可以获取所在的Activity；Activity通过FragmentManager的findFragmentById()findFragmentByTag获取Fragemnt


Fragment与Activity是多对多的关系



常用方法onCreatView()、onViewCreated()

AFragement

onCreatView()方法中：
View view=inflater.inlflate(R.layout.fragment_a,container,false)
return view

onViewCreated()方法中：
mTv=view.findViewById(R.id.tv_title);



ContainerActivity（要加载Fragment的Activity）

getFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();

5/29
更改Afragment的textview中的字体
首先在AFragment中写一个静态方法
public static AFragment newInstance(String title){
    AFragment fragement=new AFragment();
    Bundle bundle=new Bundle;
    bundle.putString("title",title);
    fragment.setArguments(bundle);
    return fragment;
   
}


在onViewCreated方法中写：
if(getArguments()!=null){
 mTv_title.setText(getArguments.getString("title"));
}
在ContainnerActiviy中调用newInstance方法即可。

回退栈
1、addToBackStack(null)
2、
Fragment fragment=getFragmentManager().findFragmentByTag("c");
if(fragment!=null){
 getFragmentManager.beginTranscation().hide(fragment).add(R.id.fl_xx).addToBackStack(null).commitAollowingStateLoss();
}else{
 getFragmentManager().beginTransaction().replace(R.id.fl_fillall,dFragment).addToBackStack(null).commitAllowingStateLoss();
}


Fragment和Activity的通信
比如Fragment写一个按钮 点击改变Activity的textview

在Fragment中写一个接口
public interface IOnMessageClick{
    void onClick(Sreing text);
}
要在Activity中实现这个接口，在fragment类中要声明这个接口：
private IOnMessageClick listener; 

并且还要在Fragment中的onAttach方法中：
令 listener=(IOnMessageClick)context;
要try_catch一下
try{
         listener=(IOnMessageClick)context;
}catch(classCastException e){
   throw new classCastException("Activity必须实现IOnMessageClick接口");
}
1、在Fragement中声明接口2、在Activity中实现接口重写方法3、回到Fragment中先private 接口 名字，在onAttach（）方法中 名字=context;
在用按钮的点击事件调用名字.重写的方法 





























