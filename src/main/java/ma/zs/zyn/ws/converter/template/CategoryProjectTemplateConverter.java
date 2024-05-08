package  ma.zs.zyn.ws.converter.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.zyn.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.ws.dto.template.CategoryProjectTemplateDto;

@Component
public class CategoryProjectTemplateConverter {


    public  CategoryProjectTemplateConverter() {
    }


    public CategoryProjectTemplate toItem(CategoryProjectTemplateDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategoryProjectTemplate item = new CategoryProjectTemplate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());



        return item;
        }
    }


    public CategoryProjectTemplateDto toDto(CategoryProjectTemplate item) {
        if (item == null) {
            return null;
        } else {
            CategoryProjectTemplateDto dto = new CategoryProjectTemplateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());


        return dto;
        }
    }


	
    public List<CategoryProjectTemplate> toItem(List<CategoryProjectTemplateDto> dtos) {
        List<CategoryProjectTemplate> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (CategoryProjectTemplateDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<CategoryProjectTemplateDto> toDto(List<CategoryProjectTemplate> items) {
        List<CategoryProjectTemplateDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (CategoryProjectTemplate item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(CategoryProjectTemplateDto dto, CategoryProjectTemplate t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<CategoryProjectTemplate> copy(List<CategoryProjectTemplateDto> dtos) {
        List<CategoryProjectTemplate> result = new ArrayList<>();
        if (dtos != null) {
            for (CategoryProjectTemplateDto dto : dtos) {
                CategoryProjectTemplate instance = new CategoryProjectTemplate();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
