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
public class AvroStockSeparation extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5176904404470477734L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroStockSeparation\",\"namespace\":\"br.com.retailsales.commons.avro\",\"fields\":[{\"name\":\"stockSeparationCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Stock separation code.\"},{\"name\":\"orderCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Order code.\"},{\"name\":\"invoiceCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Invoice code.\"},{\"name\":\"processingDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroStockSeparation> ENCODER =
      new BinaryMessageEncoder<AvroStockSeparation>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroStockSeparation> DECODER =
      new BinaryMessageDecoder<AvroStockSeparation>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<AvroStockSeparation> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<AvroStockSeparation> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroStockSeparation>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this AvroStockSeparation to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a AvroStockSeparation from a ByteBuffer. */
  public static AvroStockSeparation fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Stock separation code. */
   private java.lang.String stockSeparationCode;
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
  public AvroStockSeparation() {}

  /**
   * All-args constructor.
   * @param stockSeparationCode Stock separation code.
   * @param orderCode Order code.
   * @param invoiceCode Invoice code.
   * @param processingDate The new value for processingDate
   */
  public AvroStockSeparation(java.lang.String stockSeparationCode, java.lang.String orderCode, java.lang.String invoiceCode, org.joda.time.DateTime processingDate) {
    this.stockSeparationCode = stockSeparationCode;
    this.orderCode = orderCode;
    this.invoiceCode = invoiceCode;
    this.processingDate = processingDate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return stockSeparationCode;
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
    case 0: stockSeparationCode = (java.lang.String)value$; break;
    case 1: orderCode = (java.lang.String)value$; break;
    case 2: invoiceCode = (java.lang.String)value$; break;
    case 3: processingDate = (org.joda.time.DateTime)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'stockSeparationCode' field.
   * @return Stock separation code.
   */
  public java.lang.String getStockSeparationCode() {
    return stockSeparationCode;
  }

  /**
   * Sets the value of the 'stockSeparationCode' field.
   * Stock separation code.
   * @param value the value to set.
   */
  public void setStockSeparationCode(java.lang.String value) {
    this.stockSeparationCode = value;
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
   * Creates a new AvroStockSeparation RecordBuilder.
   * @return A new AvroStockSeparation RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroStockSeparation.Builder newBuilder() {
    return new br.com.retailsales.commons.avro.AvroStockSeparation.Builder();
  }

  /**
   * Creates a new AvroStockSeparation RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroStockSeparation RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroStockSeparation.Builder newBuilder(br.com.retailsales.commons.avro.AvroStockSeparation.Builder other) {
    return new br.com.retailsales.commons.avro.AvroStockSeparation.Builder(other);
  }

  /**
   * Creates a new AvroStockSeparation RecordBuilder by copying an existing AvroStockSeparation instance.
   * @param other The existing instance to copy.
   * @return A new AvroStockSeparation RecordBuilder
   */
  public static br.com.retailsales.commons.avro.AvroStockSeparation.Builder newBuilder(br.com.retailsales.commons.avro.AvroStockSeparation other) {
    return new br.com.retailsales.commons.avro.AvroStockSeparation.Builder(other);
  }

  /**
   * RecordBuilder for AvroStockSeparation instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroStockSeparation>
    implements org.apache.avro.data.RecordBuilder<AvroStockSeparation> {

    /** Stock separation code. */
    private java.lang.String stockSeparationCode;
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
    private Builder(br.com.retailsales.commons.avro.AvroStockSeparation.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.stockSeparationCode)) {
        this.stockSeparationCode = data().deepCopy(fields()[0].schema(), other.stockSeparationCode);
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
     * Creates a Builder by copying an existing AvroStockSeparation instance
     * @param other The existing instance to copy.
     */
    private Builder(br.com.retailsales.commons.avro.AvroStockSeparation other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.stockSeparationCode)) {
        this.stockSeparationCode = data().deepCopy(fields()[0].schema(), other.stockSeparationCode);
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
      * Gets the value of the 'stockSeparationCode' field.
      * Stock separation code.
      * @return The value.
      */
    public java.lang.String getStockSeparationCode() {
      return stockSeparationCode;
    }

    /**
      * Sets the value of the 'stockSeparationCode' field.
      * Stock separation code.
      * @param value The value of 'stockSeparationCode'.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder setStockSeparationCode(java.lang.String value) {
      validate(fields()[0], value);
      this.stockSeparationCode = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'stockSeparationCode' field has been set.
      * Stock separation code.
      * @return True if the 'stockSeparationCode' field has been set, false otherwise.
      */
    public boolean hasStockSeparationCode() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'stockSeparationCode' field.
      * Stock separation code.
      * @return This builder.
      */
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder clearStockSeparationCode() {
      stockSeparationCode = null;
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
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder setOrderCode(java.lang.String value) {
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
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder clearOrderCode() {
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
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder setInvoiceCode(java.lang.String value) {
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
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder clearInvoiceCode() {
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
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder setProcessingDate(org.joda.time.DateTime value) {
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
    public br.com.retailsales.commons.avro.AvroStockSeparation.Builder clearProcessingDate() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroStockSeparation build() {
      try {
        AvroStockSeparation record = new AvroStockSeparation();
        record.stockSeparationCode = fieldSetFlags()[0] ? this.stockSeparationCode : (java.lang.String) defaultValue(fields()[0], record.getConversion(0));
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
  private static final org.apache.avro.io.DatumWriter<AvroStockSeparation>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroStockSeparation>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroStockSeparation>
    READER$ = (org.apache.avro.io.DatumReader<AvroStockSeparation>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
