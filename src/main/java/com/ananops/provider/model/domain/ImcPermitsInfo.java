package com.ananops.provider.model.domain;

import com.ananops.provider.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "imc_permits_info")
public class ImcPermitsInfo extends BaseEntity {
    private static final long serialVersionUID = -5239474438574546264L;
    /**
     * 项目ID
     */
    @Column(name = "project_id")
    private Long projectId;

    /**
     * 证照ID
     */
    @Column(name = "permits_id")
    private Long permitsId;

    /**
     * 证照名称
     */
    @Column(name = "permits_name")
    private String permitsName;

    /**
     * 证照描述
     */
    private String description;
}