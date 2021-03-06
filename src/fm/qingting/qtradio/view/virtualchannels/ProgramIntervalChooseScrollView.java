package fm.qingting.qtradio.view.virtualchannels;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View.MeasureSpec;
import fm.qingting.framework.event.IEventHandler;
import fm.qingting.framework.view.ScrollViewImpl;
import fm.qingting.framework.view.ViewLayout;
import fm.qingting.qtradio.manager.QtApiLevelManager;

class ProgramIntervalChooseScrollView extends ScrollViewImpl
  implements IEventHandler
{
  private ProgramIntervalChooseView mChooseView;
  private final ViewLayout maxLayout = ViewLayout.createViewLayoutWithBoundsLT(720, 180, 720, 170, 0, 0, ViewLayout.SCALE_FLAG_SLTCW);

  @TargetApi(9)
  public ProgramIntervalChooseScrollView(Context paramContext)
  {
    super(paramContext);
    this.mChooseView = new ProgramIntervalChooseView(paramContext);
    addView(this.mChooseView);
    this.mChooseView.setEventHandler(this);
    if (QtApiLevelManager.isApiLevelSupported(9))
      setOverScrollMode(2);
  }

  public void onEvent(Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramString.equalsIgnoreCase("jumptopoint"))
      dispatchActionEvent(paramString, paramObject2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.maxLayout.scaleToBounds(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    this.maxLayout.measureView(this.mChooseView);
    int i = this.mChooseView.getMeasuredHeight();
    if (i > this.maxLayout.height)
      i = this.maxLayout.height;
    setMeasuredDimension(this.maxLayout.width, i);
  }

  public void update(String paramString, Object paramObject)
  {
    if (paramString.equalsIgnoreCase("setData"))
      this.mChooseView.update(paramString, paramObject);
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.virtualchannels.ProgramIntervalChooseScrollView
 * JD-Core Version:    0.6.2
 */