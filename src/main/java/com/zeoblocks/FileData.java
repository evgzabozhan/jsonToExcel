package com.zeoblocks;

public class FileData {
    public FileData(String parameter, String required, String dataType, String format) {
        Parameter = parameter;
        Required = required;
        DataType = dataType;
        Format = format;
    }
    public String Parameter;
    public String Required;
    public String DataType;
    public String Format;

    @Override
    public String toString() {
        return
                "Parameter='" + Parameter + '\'' + ", Required='" + Required + '\'' +
                ", DataType='" + DataType + '\'' +
                ", Format='" + Format + '\'' +
                '}';
    }

    public String getParameter() {
        return Parameter;
    }

    public void setParameter(String parameter) {
        Parameter = parameter;
    }

    public String getRequired() {
        return Required;
    }

    public void setRequired(String required) {
        Required = required;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
