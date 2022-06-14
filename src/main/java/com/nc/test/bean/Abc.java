package com.nc.test.bean;

import com.alibaba.fastjson.JSON;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_abc")
public class Abc   {
    /** v偏移 */
    
    @Column(name = "v_offset")
    private Integer vOffset;
    /** 连接地址 */
    
    @Column(name = "src")
    private String src;
    /** 名称 */
    
    @Column(name = "name")
    private String name;
    /** 某种属性 */
    
    @Column(name = "alignment")
    private String alignment;
    /** h偏移 */
    
    @Column(name = "h_offset")
    private Integer hOffset;
    /** 主键 */
    @Id
    @GenericGenerator(name = "generic_generator", strategy = "uuid")
    @GeneratedValue(generator = "generic_generator")
    @Column(name = "id")
    private String id;

    public void setVOffset(Integer vOffset){
        this.vOffset = vOffset;
    }
    public Integer getVOffset(){
        return this.vOffset;
    }
    public void setSrc(String src){
        this.src = src;
    }
    public String getSrc(){
        return this.src;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAlignment(String alignment){
        this.alignment = alignment;
    }
    public String getAlignment(){
        return this.alignment;
    }
    public void setHOffset(Integer hOffset){
        this.hOffset = hOffset;
    }
    public Integer getHOffset(){
        return this.hOffset;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}