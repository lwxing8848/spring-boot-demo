package ${basePackageMap['dao'].packageName};

import org.apache.ibatis.annotations.Mapper;

/**
* @author ${author!}
* @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
**/
@Mapper
public interface ${basePackageMap['dao'].className} extends BaseMapper<${basePackageMap['model'].className}>{


}
