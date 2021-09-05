package generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


public class MpGenerator {
    /*
    根据数据库生成mybatis代码
     */
    public static void main(String[] args){
        AutoGenerator mpg = new AutoGenerator();
        // 下面是全局配置
        GlobalConfig gc = new GlobalConfig();
        // gc.setOutputDir("F:\\网安项目\\教育平台项目\\测试生成代码");
        gc.setOutputDir(".\\server\\common\\src\\main\\java");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        gc.setAuthor("刘泽彬");
        // 自定义文件明明
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);
        // 配置数据库信息
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("ab31415926ab");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/education-platform");
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel); // 表明生成策略：驼峰
        strategyConfig.setInclude(new String[] {"user"}); // 需要生成的表
        strategyConfig.setSuperServiceClass(null);
        strategyConfig.setSuperServiceImplClass(null);
        strategyConfig.setSuperMapperClass(null);
        mpg.setStrategy(strategyConfig);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.whu.dhji");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }
}
