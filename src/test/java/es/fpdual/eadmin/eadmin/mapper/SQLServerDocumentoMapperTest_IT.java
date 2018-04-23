package es.fpdual.eadmin.eadmin.mapper;

import org.junit.runner.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-configuracion/eadmin-persistencia.xml",
        "classpath:spring-configuracion/eadmin-sqlserver-persistencia.xml" })
@Rollback
public class SQLServerDocumentoMapperTest_IT extends BaseDocumentoMapperTest {

}
