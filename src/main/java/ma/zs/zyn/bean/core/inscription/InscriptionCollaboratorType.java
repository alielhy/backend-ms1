package ma.zs.zyn.bean.core.inscription;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.zyn.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "inscription_collaborator_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="inscription_collaborator_type_seq",sequenceName="inscription_collaborator_type_seq",allocationSize=1, initialValue = 1)
public class InscriptionCollaboratorType  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String name;



    public InscriptionCollaboratorType(){
        super();
    }

    public InscriptionCollaboratorType(Long id,String name){
        this.id = id;
        this.name = name ;
    }
    public InscriptionCollaboratorType(String name){
        this.name = name ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="inscription_collaborator_type_seq")
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

    @Transient
    public String getLabel() {
        label = name;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionCollaboratorType inscriptionCollaboratorType = (InscriptionCollaboratorType) o;
        return id != null && id.equals(inscriptionCollaboratorType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

