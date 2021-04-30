package com.young.demo.handler;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.ibatis.type.JdbcType.VARCHAR;

/**
 * Custom type handler for gson JsonObject, refer to http://www.mybatis.org/mybatis-3/zh/configuration.html#typeHandlers.
 */
@MappedJdbcTypes(value = VARCHAR, includeNullJdbcType = true)
@MappedTypes(JsonObject.class)
public class JsonObjectTypeHandler extends BaseTypeHandler<JsonObject> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JsonObject parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, new GsonBuilder().create().toJson(parameter));
    }

    @Override
    public JsonObject getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String databaseValue = rs.getString(columnName);
        return isBlank(databaseValue) ? null : new JsonParser().parse(databaseValue).getAsJsonObject();
    }

    @Override
    public JsonObject getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String databaseValue = rs.getString(columnIndex);
        return isBlank(databaseValue) ? null : new JsonParser().parse(databaseValue).getAsJsonObject();
    }

    @Override
    public JsonObject getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String databaseValue = cs.getString(columnIndex);
        return isBlank(databaseValue) ? null : new JsonParser().parse(databaseValue).getAsJsonObject();
    }
}
