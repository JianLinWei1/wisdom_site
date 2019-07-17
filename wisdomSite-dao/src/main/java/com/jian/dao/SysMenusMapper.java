package com.jian.dao;

import com.jian.entity.SysMenus;
import com.jian.entity.SysMenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysMenusMapper {
    long countByExample(SysMenusExample example);

    int deleteByExample(SysMenusExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenus record);

    int insertSelective(SysMenus record);

    List<SysMenus> selectByExampleWithRowbounds(SysMenusExample example, RowBounds rowBounds);

    List<SysMenus> selectByExample(SysMenusExample example);

    SysMenus selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") SysMenus record, @Param("example") SysMenusExample example);

    int updateByExample(@Param("record") SysMenus record, @Param("example") SysMenusExample example);

    int updateByPrimaryKeySelective(SysMenus record);

    int updateByPrimaryKey(SysMenus record);
    List<SysMenus>  selectMenusByRoleId(int roleId);
}