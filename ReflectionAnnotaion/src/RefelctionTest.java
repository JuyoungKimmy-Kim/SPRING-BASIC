import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class RefelctionTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, Exception {
		// 내가 직접 MyReflection 클래스를 사용할 경우 
		
//		MyReflection mr=new MyReflection ();
//		mr.aboutMe();
		
//		// Spring이 MyReflection 클래스를 사용할 경우
//		String className="MyReflection";
//		Class<?> myClass = Class.forName(className);
//		
//		// Reflection API
//		MyReflection mf=(MyReflection) myClass.getDeclaredConstructor().newInstance();
//		mf.aboutMe();
		
		// Spring이 MyReflection 클래스를 사용할 경우 by 외부 설정 파일
		InputStream is=new FileInputStream ("MyConfig.properties");
		Properties prop=new Properties ();
		prop.load(is);
		
		String className=prop.getProperty("class.name");
		Class<?> myClass = Class.forName(className);
		
		// Reflection API
		MyReflection mf=(MyReflection) myClass.getDeclaredConstructor().newInstance();
		mf.aboutMe();
		
		// parameter & return
		Method m = myClass.getMethod("robot", int.class);
		String str=(String)m.invoke(mf, 80);
		System.out.println(str);
	}

}
