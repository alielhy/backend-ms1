package ma.zs.zyn.bean.core.template;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.zyn.bean.core.collaborator.Member;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;

@Entity
@Table(name = "project_template")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="project_template_seq",sequenceName="project_template_seq",allocationSize=1, initialValue = 1)
public class ProjectTemplate  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String yaml;
    private LocalDateTime addingDate ;
    private LocalDateTime lastUpdateDate ;
    @Column(length = 500)
    private String projectTemplateTags;
    private BigDecimal price = BigDecimal.ZERO;

    private CategoryProjectTemplate categoryProjectTemplate ;
    private DomainTemplate domainTemplate ;
    private Member member ;


    public ProjectTemplate(){
        super();
    }

    public ProjectTemplate(Long id,String name){
        this.id = id;
        this.name = name ;
    }
    public ProjectTemplate(String name){
        this.name = name ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="project_template_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getYaml(){
        return this.yaml;
    }
    public void setYaml(String yaml){
        this.yaml = yaml;
    }
    public LocalDateTime getAddingDate(){
        return this.addingDate;
    }
    public void setAddingDate(LocalDateTime addingDate){
        this.addingDate = addingDate;
    }
    public LocalDateTime getLastUpdateDate(){
        return this.lastUpdateDate;
    }
    public void setLastUpdateDate(LocalDateTime lastUpdateDate){
        this.lastUpdateDate = lastUpdateDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_project_template")
    public CategoryProjectTemplate getCategoryProjectTemplate(){
        return this.categoryProjectTemplate;
    }
    public void setCategoryProjectTemplate(CategoryProjectTemplate categoryProjectTemplate){
        this.categoryProjectTemplate = categoryProjectTemplate;
    }
    public String getProjectTemplateTags(){
        return this.projectTemplateTags;
    }
    public void setProjectTemplateTags(String projectTemplateTags){
        this.projectTemplateTags = projectTemplateTags;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domain_template")
    public DomainTemplate getDomainTemplate(){
        return this.domainTemplate;
    }
    public void setDomainTemplate(DomainTemplate domainTemplate){
        this.domainTemplate = domainTemplate;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    public Member getMember(){
        return this.member;
    }
    public void setMember(Member member){
        this.member = member;
    }

    @Transient
    public String getLabel() {
        label = name;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTemplate projectTemplate = (ProjectTemplate) o;
        return id != null && id.equals(projectTemplate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

