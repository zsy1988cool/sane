package com.sane.partake.controller;

import com.sane.partake.core.result.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="hello")
public class HelloWorldController {

    @Autowired
    DataSource dataSource;

    @RequestMapping(value="show")
    public String showHello() {
        return "Hello";
    }

    @ResponseBody
    @RequestMapping(value = "getResult")
    public ResultModel getResult() {
        ResultModel model = new ResultModel();
        model.setMessage("success");
        model.setCode(ResultModel.SUCCESS_CODE);

        return model;
    }

    @ResponseBody
    @RequestMapping(value = "getData")
    public ResultModel getData() {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "select * from zoeemr.emr_intellisense where id < ?";
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "5");
            ResultSet resultSet = stmt.executeQuery();

            ResultSetMetaData md = resultSet.getMetaData();
            int columnCount = md.getColumnCount();
            List<Map<String, Object>> rsList = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> rowData = new HashMap<>();

                for(int i = 0; i < columnCount; i++) {
                    String columnName = md.getColumnName(i+1);
                    Object obj = resultSet.getObject(i+1);
                    rowData.put(columnName, obj);
                }
                rsList.add(rowData);
            }
            return ResultModel.success(rsList);
        } catch (SQLException e) {
            //
        } finally {
            try {
                if( stmt != null) {
                    stmt.close();
                }

                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                //
            }
        }

        return ResultModel.fail("获取数据失败", "数据库失败");
    }
}
