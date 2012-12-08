import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * annotation interface used to save the creator of each method and class
 * 
 * @author Thomas
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface Creator {
	String name() default "Apparently nobody";
	String lastUpdate() default "Never";
}
