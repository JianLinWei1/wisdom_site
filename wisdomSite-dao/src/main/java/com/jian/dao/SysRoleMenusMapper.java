package com.jian.dao;

import com.jian.entity.SysRoleMenus;
import com.jian.entity.SysRoleMenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRoleMenusMapper {
    long countByExample(SysRoleMenusExample example);

    int deleteByExample(SysRoleMenusExample example);

    int insert(SysRoleMenus record);

    int insertSelective(SysRoleMenus record);

    List<SysRoleMenus> selectByExampleWithRowbounds(SysRoleMenusExample example, RowBounds rowBounds);

    List<SysRoleMenus> selectByExample(SysRoleMenusExample example);

    int updateByExampleSelective(@Param("record") SysRoleMenus record, @Param("example") SysRoleMenusExample example);

    int updateByExample(@Param("record") SysRoleMenus record, @Param("example") SysRoleMenusExample example);
    

    List<Integer> selectMenusByRoleId(int roleId);
}