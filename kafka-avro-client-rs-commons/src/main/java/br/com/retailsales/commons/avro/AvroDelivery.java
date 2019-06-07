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
public class AvroDelivery extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 72772857123811707L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroDelivery\",\"namespace\":\"br.com.retailsales.commons.avro\",\"fields\":[{\"name\":\"deliveryCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Delivery code.\"},{\"name\":\"orderCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Order code.\"},{\"name\":\"invoiceCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Invoice code.\"},{\"name\":\"processingDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroDelivery> ENCODER =
      new BinaryMessageEncoder<AvroDelivery>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroDelivery> DECODER =
      new BinaryMessageDecoder<AvroDelivery>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<AvroDelivery> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<AvroDelivery> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroDelivery>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this AvroDelivery to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a AvroDelivery from a ByteBuffer. */
  public static AvroDelivery fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Delivery code. */
   private java.lang.String deliveryCode;
  /** Order code. */
   private java.lang.String orderCode;
  /** Invoice code. */
   private java.lang.String invoiceCode;
   private org.joda.time.DateTime processingDate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroDelivery() {}

  /**
   * All-args constructor.
   * @param deliveryCode Delivery code.
   * @param orderCode Order code.
   * @param invoiceCode Invoice code.
   * @param processingDate The new value for processingDate
   */
  public AvroDelivery(java.lang.String deliveryCode, java.lang.String orderCode, java.lang.String invoiceCode, org.joda.time.DateTime processingDate) {
    this.deliveryCode = deliveryCode;
    this.orderCode = orderCode;
    this.invoiceCode = invoiceCode;
    this.processingDate = processingDate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return deliveryCode;
    case 1: return orderCode;
    case 2: return invoiceCode;
    case 3: return processingDate;
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
    case 0: deliveryCode = (java.lang.String)value$; break;
    case 1: orderCode = (java.lang.String)value$; break;
    case 2: invoiceCode = (java.lang.String)value$; break;
    case 3: processingDate = (org.joda.time.DateTime)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'deliveryCode' field.
   * @return Delivery code.
   */
  public java.lang.String getDeliveryCode() {
    return deliveryCode;
  }

  /**
   * Sets the value of the 'deliveryCode' field.
   * Delivery code.
   * @param value the value to set.
   */
  public void setDeliveryCode(java.lang.String value) {
    this.deliveryCode = value;
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
   * Gets the value of the 'invoiceCode' field.
   * @return Invoice code.
   */
  public java.lang.String getInvoiceCode() {
    return invoiceCode;
  }

  /**
   * Sets the value of the 'invoiceCode' field.
   * Invoice code.
   * @param value the value to set.
   */
  public void setInvoiceCode(java.lang.String value) {
    this.invoiceCode = value;
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
   * Creates a new AvroDelivery RecordBuilder.
   * @return A new AvroDelivery RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroDelivery.Builder newBuilder() {
    return new br.com.retailsales.commons.avro.AvroDelivery.Builder();
  }

  /**
   * Creates a new AvroDelivery RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroDelivery RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroDelivery.Builder newBuilder(br.com.retailsales.commons.avro.AvroDelivery.Builder other) {
    return new br.com.retailsales.commons.avro.AvroDelivery.Builder(other);
  }

  /**
   * Creates a new AvroDelivery RecordBuilder by copying an existing AvroDelivery instance.
   * @param other The existing instance to copy.
   * @return A new AvroDelivery RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroDelivery.Builder newBuilder(br.com.retailsales.commons.avro.AvroDelivery other) {
    return new br.com.retailsales.commons.avro.AvroDelivery.Builder(other);
  }

  /**
   * RecordBuilder for AvroDelivery instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroDelivery>
    implements org.apache.avro.data.RecordBuilder<AvroDelivery> {

    /** Delivery code. */
    private java.lang.String deliveryCode;
    /** Order code. */
    private java.lang.String orderCode;
    /** Invoice code. */
    private java.lang.String invoiceCode;
    private org.joda.time.DateTime processingDate;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(br.com.retailsales.commons.avro.AvroDelivery.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.deliveryCode)) {
        this.deliveryCode = data().deepCopy(fields()[0].schema(), other.deliveryCode);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderCode)) {
        this.orderCode = data().deepCopy(fields()[1].schema(), other.orderCode);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.invoiceCode)) {
        this.invoiceCode = data().deepCopy(fields()[2].schema(), other.invoiceCode);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.processingDate)) {
        this.processingDate = data().deepCopy(fields()[3].schema(), other.processingDate);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AvroDelivery instance
     * @param other The existing instance to copy.
     */
    private Builder(br.com.retailsales.commons.avro.AvroDelivery other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.deliveryCode)) {
        this.deliveryCode = data().deepCopy(fields()[0].schema(), other.deliveryCode);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderCode)) {
        this.orderCode = data().deepCopy(fields()[1].schema(), other.orderCode);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.invoiceCode)) {
        this.invoiceCode = data().deepCopy(fields()[2].schema(), other.invoiceCode);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.processingDate)) {
        this.processingDate = data().deepCopy(fields()[3].schema(), other.processingDate);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'deliveryCode' field.
      * Delivery code.
      * @return The value.
      */
    public java.lang.String getDeliveryCode() {
      return deliveryCode;
    }

    /**
      * Sets the value of the 'deliveryCode' field.
      * Delivery code.
      * @param value The value of 'deliveryCode'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroDelivery.Builder setDeliveryCode(java.lang.String value) {
      validate(fields()[0], value);
      this.deliveryCode = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'deliveryCode' field has been set.
      * Delivery code.
      * @return True if the 'deliveryCode' field has been set, false otherwise.
      */
    public boolean hasDeliveryCode() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'deliveryCode' field.
      * Delivery code.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroDelivery.Builder clearDeliveryCode() {
      deliveryCode = null;
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
    public br.com.retailsales.commons.avro.AvroDelivery.Builder setOrderCode(java.lang.String value) {
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
    public br.com.retailsales.commons.avro.AvroDelivery.Builder clearOrderCode() {
      orderCode = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'invoiceCode' field.
      * Invoice code.
      * @return The value.
      */
    public java.lang.String getInvoiceCode() {
      return invoiceCode;
    }

    /**
      * Sets the value of the 'invoiceCode' field.
      * Invoice code.
      * @param value The value of 'invoiceCode'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroDelivery.Builder setInvoiceCode(java.lang.String value) {
      validate(fields()[2], value);
      this.invoiceCode = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'invoiceCode' field has been set.
      * Invoice code.
      * @return True if the 'invoiceCode' field has been set, false otherwise.
      */
    public boolean hasInvoiceCode() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'invoiceCode' field.
      * Invoice code.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroDelivery.Builder clearInvoiceCode() {
      invoiceCode = null;
      fieldSetFlags()[2] = false;
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
    public br.com.retailsales.commons.avro.AvroDelivery.Builder setProcessingDate(org.joda.time.DateTime value) {
      validate(fields()[3], value);
      this.processingDate = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'processingDate' field has been set.
      * @return True if the 'processingDate' field has been set, false otherwise.
      */
    public boolean hasProcessingDate() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'processingDate' field.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroDelivery.Builder clearProcessingDate() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroDelivery build() {
      try {
        AvroDelivery record = new AvroDelivery();
        record.deliveryCode = fieldSetFlags()[0] ? this.deliveryCode : (java.lang.String) defaultValue(fields()[0], record.getConversion(0));
        record.orderCode = fieldSetFlags()[1] ? this.orderCode : (java.lang.String) defaultValue(fields()[1], record.getConversion(1));
        record.invoiceCode = fieldSetFlags()[2] ? this.invoiceCode : (java.lang.String) defaultValue(fields()[2], record.getConversion(2));
        record.processingDate = fieldSetFlags()[3] ? this.processingDate : (org.joda.time.DateTime) defaultValue(fields()[3], record.getConversion(3));
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroDelivery>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroDelivery>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroDelivery>
    READER$ = (org.apache.avro.io.DatumReader<AvroDelivery>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
