package ir.codefather.drivers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


// Spring will use these at runtime to inject and set these variable values from specified property file.\
// Below is the properties declared in mysqldatabase.properties file.
@Component
@PropertySource("classpath:mysqldatabase.properties")
public class MySqlDriver implements DataBaseDriver {

    @Value("${databaseName}")
    private String databaseName;
    @Value("${disableStatementPooling}")
    private String disableStatementPooling;

    public String getInfo() {
        return "[ Driver: mySql" +
                ", databaseName: " + databaseName +
                ", disableStatementPooling: " + disableStatementPooling +
                " ]";
    }
}
