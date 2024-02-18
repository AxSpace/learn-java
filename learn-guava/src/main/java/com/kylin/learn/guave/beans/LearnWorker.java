package com.kylin.learn.guave.beans;

/**
 * @author kylin
 * @classname LearnWorker
 * @date 2024/2/16 20:18
 */
public class LearnWorker {

    /**
     * 序列号
     */
    private String sequenceNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号
     */
    private String certNo;

    /**
     * 证件类型
     */
    private String certType;

    private LearnWorker() {
    }

    private LearnWorker(Builder builder) {
        setSequenceNo(builder.sequenceNo);
        setName(builder.name);
        setCertNo(builder.certNo);
        setCertType(builder.certType);
    }

    public static Builder builder() {
        return new Builder();
    }


    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }


    @Override
    public String toString() {
        return "LearnWorker{" +
                "sequenceNo='" + sequenceNo + '\'' +
                ", name='" + name + '\'' +
                ", certNo='" + certNo + '\'' +
                ", certType='" + certType + '\'' +
                '}';
    }

    public static final class Builder {
        private String sequenceNo;
        private String name;
        private String certNo;
        private String certType;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder sequenceNo(String sequenceNo) {
            this.sequenceNo = sequenceNo;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder certNo(String certNo) {
            this.certNo = certNo;
            return this;
        }

        public Builder certType(String certType) {
            this.certType = certType;
            return this;
        }

        public LearnWorker build() {
            return new LearnWorker(this);
        }
    }
}
