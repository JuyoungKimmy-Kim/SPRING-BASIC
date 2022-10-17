import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // 실행할 때도 이 @을 쓰겠다
public @interface MyAnnotation {
	String love();
	String hate();
}


// @MyAnnotation -> 이런 식으로 사용 가능
// Container vs Component
// 