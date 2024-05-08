package ma.zs.zyn.dao.facade.core.template;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CategoryProjectTemplateDao extends AbstractRepository<CategoryProjectTemplate,Long>  {


    @Query("SELECT NEW CategoryProjectTemplate(item.id,item.name) FROM CategoryProjectTemplate item")
    List<CategoryProjectTemplate> findAllOptimized();

}
