package ma.zs.zyn.integration.core.template.category-project-template;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class CategoryProjectTemplateIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("CategoryProjectTemplateHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
