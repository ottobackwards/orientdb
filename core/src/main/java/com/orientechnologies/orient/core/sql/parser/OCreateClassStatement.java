/* Generated By:JJTree: Do not edit this line. OCreateClassStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OCreateClassStatement extends OStatement {
  /**
   * Class name
   */
  public OIdentifier name;

  /**
   * Direct superclasses for this class
   */
  protected List<OIdentifier> superclasses;

  /**
   * Cluster IDs for this class
   */
  protected List<OInteger> clusters;

  /**
   * Total number clusters for this class
   */
  protected OInteger totalClusterNo;

  protected boolean abstractClass = false;

  public OCreateClassStatement(int id) {
    super(id);
  }

  public OCreateClassStatement(OrientSql p, int id) {
    super(p, id);
  }

  @Override public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append("CREATE CLASS ");
    name.toString(params, builder);
    if (superclasses != null && superclasses.size() > 0) {
      builder.append(" EXTENDS ");
      boolean first = true;
      for (OIdentifier sup : superclasses) {
        if (!first) {
          builder.append(", ");
        }
        sup.toString(params, builder);
        first = false;
      }
    }
    if (clusters != null && clusters.size() > 0) {
      builder.append(" CLUSTER ");
      boolean first = true;
      for (OInteger cluster : clusters) {
        if (!first) {
          builder.append(",");
        }
        cluster.toString(params, builder);
        first = false;
      }
    }
    if (totalClusterNo != null) {
      builder.append(" CLUSTERS ");
      totalClusterNo.toString(params, builder);
    }
    if (abstractClass) {
      builder.append(" ABSTRACT");
    }
  }

  @Override public OCreateClassStatement copy() {
    OCreateClassStatement result = new OCreateClassStatement(-1);
    result.name = name == null ? null : name.copy();
    result.superclasses = superclasses == null ? null : superclasses.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.clusters = clusters == null ? null : clusters.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.totalClusterNo = totalClusterNo == null ? null : totalClusterNo.copy();
    result.abstractClass = abstractClass;
    return result;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    OCreateClassStatement that = (OCreateClassStatement) o;

    if (abstractClass != that.abstractClass)
      return false;
    if (name != null ? !name.equals(that.name) : that.name != null)
      return false;
    if (superclasses != null ? !superclasses.equals(that.superclasses) : that.superclasses != null)
      return false;
    if (clusters != null ? !clusters.equals(that.clusters) : that.clusters != null)
      return false;
    if (totalClusterNo != null ? !totalClusterNo.equals(that.totalClusterNo) : that.totalClusterNo != null)
      return false;

    return true;
  }

  @Override public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (superclasses != null ? superclasses.hashCode() : 0);
    result = 31 * result + (clusters != null ? clusters.hashCode() : 0);
    result = 31 * result + (totalClusterNo != null ? totalClusterNo.hashCode() : 0);
    result = 31 * result + (abstractClass ? 1 : 0);
    return result;
  }
}
/* JavaCC - OriginalChecksum=4043013624f55fdf0ea8fee6d4f211b0 (do not edit this line) */