package com.sonymm.manager.mybatis.converter;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/15 17:20
 */
public class BooleanIntegerConverter implements TypeHandler<Boolean> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int columnIndex, Boolean parameter, JdbcType jdbcType) throws SQLException {
        Boolean b = parameter;
        Integer value = b ? 1 : 0;
        preparedStatement.setInt(columnIndex, value);
    }

    @Override
    public Boolean getResult(ResultSet resultSet, String columnName) throws SQLException {
        Integer value = resultSet.getInt(columnName);
        return value == 1;
    }

    @Override
    public Boolean getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        Integer value = resultSet.getInt(columnIndex);
        return value == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        Integer value = callableStatement.getInt(columnIndex);
        return value == 1 ? Boolean.TRUE : Boolean.FALSE;
    }
}
