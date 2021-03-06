/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package br.com.retailsales.commons.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroPayment extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1747013306029772867L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroPayment\",\"namespace\":\"br.com.retailsales.commons.avro\",\"fields\":[{\"name\":\"paymentCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Payment code.\"},{\"name\":\"orderCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Order code.\"},{\"name\":\"totalAmount\",\"type\":\"int\",\"doc\":\"Total order amount.\"},{\"name\":\"totalValue\",\"type\":\"double\",\"doc\":\"Total order value.\"},{\"name\":\"processingDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroPayment> ENCODER =
      new BinaryMessageEncoder<AvroPayment>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroPayment> DECODER =
      new BinaryMessageDecoder<AvroPayment>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<AvroPayment> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<AvroPayment> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroPayment>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this AvroPayment to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a AvroPayment from a ByteBuffer. */
  public static AvroPayment fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Payment code. */
   private java.lang.String paymentCode;
  /** Order code. */
   private java.lang.String orderCode;
  /** Total order amount. */
   private int totalAmount;
  /** Total order value. */
   private double totalValue;
   private org.joda.time.DateTime processingDate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroPayment() {}

  /**
   * All-args constructor.
   * @param paymentCode Payment code.
   * @param orderCode Order code.
   * @param totalAmount Total order amount.
   * @param totalValue Total order value.
   * @param processingDate The new value for processingDate
   */
  public AvroPayment(java.lang.String paymentCode, java.lang.String orderCode, java.lang.Integer totalAmount, java.lang.Double totalValue, org.joda.time.DateTime processingDate) {
    this.paymentCode = paymentCode;
    this.orderCode = orderCode;
    this.totalAmount = totalAmount;
    this.totalValue = totalValue;
    this.processingDate = processingDate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return paymentCode;
    case 1: return orderCode;
    case 2: return totalAmount;
    case 3: return totalValue;
    case 4: return processingDate;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  protected static final org.apache.avro.data.TimeConversions.DateConversion DATE_CONVERSION = new org.apache.avro.data.TimeConversions.DateConversion();
  protected static final org.apache.avro.data.TimeConversions.TimeConversion TIME_CONVERSION = new org.apache.avro.data.TimeConversions.TimeConversion();
  protected static final org.apache.avro.data.TimeConversions.TimestampConversion TIMESTAMP_CONVERSION = new org.apache.avro.data.TimeConversions.TimestampConversion();
  protected static final org.apache.avro.Conversions.DecimalConversion DECIMAL_CONVERSION = new org.apache.avro.Conversions.DecimalConversion();

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      TIMESTAMP_CONVERSION,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: paymentCode = (java.lang.String)value$; break;
    case 1: orderCode = (java.lang.String)value$; break;
    case 2: totalAmount = (java.lang.Integer)value$; break;
    case 3: totalValue = (java.lang.Double)value$; break;
    case 4: processingDate = (org.joda.time.DateTime)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'paymentCode' field.
   * @return Payment code.
   */
  public java.lang.String getPaymentCode() {
    return paymentCode;
  }

  /**
   * Sets the value of the 'paymentCode' field.
   * Payment code.
   * @param value the value to set.
   */
  public void setPaymentCode(java.lang.String value) {
    this.paymentCode = value;
  }

  /**
   * Gets the value of the 'orderCode' field.
   * @return Order code.
   */
  public java.lang.String getOrderCode() {
    return orderCode;
  }

  /**
   * Sets the value of the 'orderCode' field.
   * Order code.
   * @param value the value to set.
   */
  public void setOrderCode(java.lang.String value) {
    this.orderCode = value;
  }

  /**
   * Gets the value of the 'totalAmount' field.
   * @return Total order amount.
   */
  public java.lang.Integer getTotalAmount() {
    return totalAmount;
  }

  /**
   * Sets the value of the 'totalAmount' field.
   * Total order amount.
   * @param value the value to set.
   */
  public void setTotalAmount(java.lang.Integer value) {
    this.totalAmount = value;
  }

  /**
   * Gets the value of the 'totalValue' field.
   * @return Total order value.
   */
  public java.lang.Double getTotalValue() {
    return totalValue;
  }

  /**
   * Sets the value of the 'totalValue' field.
   * Total order value.
   * @param value the value to set.
   */
  public void setTotalValue(java.lang.Double value) {
    this.totalValue = value;
  }

  /**
   * Gets the value of the 'processingDate' field.
   * @return The value of the 'processingDate' field.
   */
  public org.joda.time.DateTime getProcessingDate() {
    return processingDate;
  }

  /**
   * Sets the value of the 'processingDate' field.
   * @param value the value to set.
   */
  public void setProcessingDate(org.joda.time.DateTime value) {
    this.processingDate = value;
  }

  /**
   * Creates a new AvroPayment RecordBuilder.
   * @return A new AvroPayment RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroPayment.Builder newBuilder() {
    return new br.com.retailsales.commons.avro.AvroPayment.Builder();
  }

  /**
   * Creates a new AvroPayment RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroPayment RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroPayment.Builder newBuilder(br.com.retailsales.commons.avro.AvroPayment.Builder other) {
    return new br.com.retailsales.commons.avro.AvroPayment.Builder(other);
  }

  /**
   * Creates a new AvroPayment RecordBuilder by copying an existing AvroPayment instance.
   * @param other The existing instance to copy.
   * @return A new AvroPayment RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroPayment.Builder newBuilder(br.com.retailsales.commons.avro.AvroPayment other) {
    return new br.com.retailsales.commons.avro.AvroPayment.Builder(other);
  }

  /**
   * RecordBuilder for AvroPayment instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroPayment>
    implements org.apache.avro.data.RecordBuilder<AvroPayment> {

    /** Payment code. */
    private java.lang.String paymentCode;
    /** Order code. */
    private java.lang.String orderCode;
    /** Total order amount. */
    private int totalAmount;
    /** Total order value. */
    private double totalValue;
    private org.joda.time.DateTime processingDate;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(br.com.retailsales.commons.avro.AvroPayment.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.paymentCode)) {
        this.paymentCode = data().deepCopy(fields()[0].schema(), other.paymentCode);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderCode)) {
        this.orderCode = data().deepCopy(fields()[1].schema(), other.orderCode);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.totalAmount)) {
        this.totalAmount = data().deepCopy(fields()[2].schema(), other.totalAmount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalValue)) {
        this.totalValue = data().deepCopy(fields()[3].schema(), other.totalValue);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.processingDate)) {
        this.processingDate = data().deepCopy(fields()[4].schema(), other.processingDate);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AvroPayment instance
     * @param other The existing instance to copy.
     */
    private Builder(br.com.retailsales.commons.avro.AvroPayment other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.paymentCode)) {
        this.paymentCode = data().deepCopy(fields()[0].schema(), other.paymentCode);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderCode)) {
        this.orderCode = data().deepCopy(fields()[1].schema(), other.orderCode);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.totalAmount)) {
        this.totalAmount = data().deepCopy(fields()[2].schema(), other.totalAmount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.totalValue)) {
        this.totalValue = data().deepCopy(fields()[3].schema(), other.totalValue);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.processingDate)) {
        this.processingDate = data().deepCopy(fields()[4].schema(), other.processingDate);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'paymentCode' field.
      * Payment code.
      * @return The value.
      */
    public java.lang.String getPaymentCode() {
      return paymentCode;
    }

    /**
      * Sets the value of the 'paymentCode' field.
      * Payment code.
      * @param value The value of 'paymentCode'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder setPaymentCode(java.lang.String value) {
      validate(fields()[0], value);
      this.paymentCode = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'paymentCode' field has been set.
      * Payment code.
      * @return True if the 'paymentCode' field has been set, false otherwise.
      */
    public boolean hasPaymentCode() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'paymentCode' field.
      * Payment code.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder clearPaymentCode() {
      paymentCode = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderCode' field.
      * Order code.
      * @return The value.
      */
    public java.lang.String getOrderCode() {
      return orderCode;
    }

    /**
      * Sets the value of the 'orderCode' field.
      * Order code.
      * @param value The value of 'orderCode'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder setOrderCode(java.lang.String value) {
      validate(fields()[1], value);
      this.orderCode = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'orderCode' field has been set.
      * Order code.
      * @return True if the 'orderCode' field has been set, false otherwise.
      */
    public boolean hasOrderCode() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'orderCode' field.
      * Order code.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder clearOrderCode() {
      orderCode = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalAmount' field.
      * Total order amount.
      * @return The value.
      */
    public java.lang.Integer getTotalAmount() {
      return totalAmount;
    }

    /**
      * Sets the value of the 'totalAmount' field.
      * Total order amount.
      * @param value The value of 'totalAmount'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder setTotalAmount(int value) {
      validate(fields()[2], value);
      this.totalAmount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'totalAmount' field has been set.
      * Total order amount.
      * @return True if the 'totalAmount' field has been set, false otherwise.
      */
    public boolean hasTotalAmount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'totalAmount' field.
      * Total order amount.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder clearTotalAmount() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'totalValue' field.
      * Total order value.
      * @return The value.
      */
    public java.lang.Double getTotalValue() {
      return totalValue;
    }

    /**
      * Sets the value of the 'totalValue' field.
      * Total order value.
      * @param value The value of 'totalValue'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder setTotalValue(double value) {
      validate(fields()[3], value);
      this.totalValue = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'totalValue' field has been set.
      * Total order value.
      * @return True if the 'totalValue' field has been set, false otherwise.
      */
    public boolean hasTotalValue() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'totalValue' field.
      * Total order value.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder clearTotalValue() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'processingDate' field.
      * @return The value.
      */
    public org.joda.time.DateTime getProcessingDate() {
      return processingDate;
    }

    /**
      * Sets the value of the 'processingDate' field.
      * @param value The value of 'processingDate'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder setProcessingDate(org.joda.time.DateTime value) {
      validate(fields()[4], value);
      this.processingDate = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'processingDate' field has been set.
      * @return True if the 'processingDate' field has been set, false otherwise.
      */
    public boolean hasProcessingDate() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'processingDate' field.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroPayment.Builder clearProcessingDate() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroPayment build() {
      try {
        AvroPayment record = new AvroPayment();
        record.paymentCode = fieldSetFlags()[0] ? this.paymentCode : (java.lang.String) defaultValue(fields()[0], record.getConversion(0));
        record.orderCode = fieldSetFlags()[1] ? this.orderCode : (java.lang.String) defaultValue(fields()[1], record.getConversion(1));
        record.totalAmount = fieldSetFlags()[2] ? this.totalAmount : (java.lang.Integer) defaultValue(fields()[2], record.getConversion(2));
        record.totalValue = fieldSetFlags()[3] ? this.totalValue : (java.lang.Double) defaultValue(fields()[3], record.getConversion(3));
        record.processingDate = fieldSetFlags()[4] ? this.processingDate : (org.joda.time.DateTime) defaultValue(fields()[4], record.getConversion(4));
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroPayment>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroPayment>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroPayment>
    READER$ = (org.apache.avro.io.DatumReader<AvroPayment>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
