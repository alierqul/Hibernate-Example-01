package com.aliergul.app.utils;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class PGDialect extends PostgreSQL95Dialect {
  public PGDialect() {
    super();
    registerFunction("string_agg",
        new SQLFunctionTemplate(StandardBasicTypes.STRING, "string_agg(?1, ?2)"));
  }
}
