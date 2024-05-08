package ma.zs.zyn.dao.facade.core.project;

import org.springframework.data.jpa.repository.Query;
import ma.zs.zyn.zynerator.repository.AbstractRepository;
import ma.zs.zyn.bean.core.project.Project;
import org.springframework.stereotype.Repository;
import ma.zs.zyn.bean.core.project.Project;
import java.util.List;


@Repository
public interface ProjectDao extends AbstractRepository<Project,Long>  {
    Project findByCode(String code);
    int deleteByCode(String code);

    List<Project> findByProjectStateCode(String code);
            public int deleteByProjectStateCode(String code);
    long countByProjectStateCode(String code);
    List<Project> findByInscriptionMembreId(Long id);
    int deleteByInscriptionMembreId(Long id);
    long countByInscriptionMembreId(Long id);
    List<Project> findByProjectTemplateId(Long id);
    int deleteByProjectTemplateId(Long id);
    long countByProjectTemplateCode(String code);
    List<Project> findByDomainTemplateId(Long id);
    int deleteByDomainTemplateId(Long id);
    long countByDomainTemplateId(Long id);

    @Query("SELECT NEW Project(item.id,item.code) FROM Project item")
    List<Project> findAllOptimized();

}
