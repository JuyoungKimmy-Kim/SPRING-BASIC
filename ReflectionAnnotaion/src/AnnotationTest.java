import java.lang.annotation.Annotation;


// 스프링 역할을 하는 간단한 프로그램
public class AnnotationTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<?> myClass = Class.forName("UseMyAnnotation");
		Annotation[] annotations=myClass.getAnnotations();
		
		for (Annotation annotation : annotations) {
			if (annotation instanceof MyAnnotation) {
				MyAnnotation myAnnotation = (MyAnnotation) annotation;
				System.out.println(myAnnotation.love());
				System.out.println(myAnnotation.hate());
			}
		}
	}

}

// 스프링으로 코드를 작성한다는 것은 많은 annotation, xml, java bean클래스를 이용해서
// 스프링과 소통하는 것이 매우 중요