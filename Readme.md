第二次作业
作业1：
Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?

思路：找到一个比acticity的生命要长的application来存储我们的log信息
定义一个记录log信息的Application
public class MyApplication extends Application {
    String message;
    public MyApplication() {
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
实例化：myApplication = (MyApplication) getApplication();
在onDestroy（）里面每次将所有的log信息写入。
在onCreate（）中把myApplication的信息读出展示。

作业2：一个抖音笔试题：统计页面所有view的个数
Tips：ViewGroup有两个API
@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
用一个TextView展示出来

public int getAllChildViewCount(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                getAllChildViewCount(viewchild);
            }
        }
        else
            sum++;
        return 0;
    }
 


练习三：

消息列表：
聊天室：adpter通过判断消息类型来决定item布局怎么现实

 
