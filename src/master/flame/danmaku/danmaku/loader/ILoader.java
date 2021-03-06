package master.flame.danmaku.danmaku.loader;

import java.io.InputStream;
import master.flame.danmaku.danmaku.parser.IDataSource;

public abstract interface ILoader
{
  public abstract IDataSource<?> getDataSource();

  public abstract void load(InputStream paramInputStream)
    throws IllegalDataException;

  public abstract void load(String paramString)
    throws IllegalDataException;
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     master.flame.danmaku.danmaku.loader.ILoader
 * JD-Core Version:    0.6.2
 */