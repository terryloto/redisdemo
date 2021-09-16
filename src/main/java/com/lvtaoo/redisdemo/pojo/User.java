package com.lvtaoo.redisdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * @Description TODO
 * @Author lvtao
 * @Date 2021/9/10 15:07
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    String name;

    Integer age;
}
