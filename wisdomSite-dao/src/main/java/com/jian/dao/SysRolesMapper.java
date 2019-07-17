package com.jian.dao;

import com.jian.entity.SysRoles;
import com.jian.entity.SysRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRolesMapper {
    long countByExample(SysRolesExample example);

    int deleteByExample(SysRolesExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);

    List<SysRoles> selectByExampleWithRowbounds(SysRolesExample example, RowBounds rowBounds);

    List<SysRoles> selectByExample(SysRolesExample example);

    SysRoles selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") SysRoles record, @Param("example") SysRolesExample example);

    int updateByExample(@Param("record") SysRoles record, @Param("example") SysRolesExample example);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);
}