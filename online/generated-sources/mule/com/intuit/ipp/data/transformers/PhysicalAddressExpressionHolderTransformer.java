
package com.intuit.ipp.data.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.holders.PhysicalAddressExpressionHolder;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.quickbooks.online.processors.AbstractExpressionEvaluator;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class PhysicalAddressExpressionHolderTransformer
    extends AbstractExpressionEvaluator
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == PhysicalAddressExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == PhysicalAddressExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {PhysicalAddressExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(PhysicalAddressExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return PhysicalAddress.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(PhysicalAddress.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        PhysicalAddressExpressionHolder holder = ((PhysicalAddressExpressionHolder) src);
        PhysicalAddress result = new PhysicalAddress();
        try {
            final String _transformedId = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final String _transformedLine1 = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_line1Type").getGenericType(), null, holder.getLine1()));
            result.setLine1(_transformedLine1);
            final String _transformedLine2 = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_line2Type").getGenericType(), null, holder.getLine2()));
            result.setLine2(_transformedLine2);
            final String _transformedLine3 = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_line3Type").getGenericType(), null, holder.getLine3()));
            result.setLine3(_transformedLine3);
            final String _transformedLine4 = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_line4Type").getGenericType(), null, holder.getLine4()));
            result.setLine4(_transformedLine4);
            final String _transformedLine5 = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_line5Type").getGenericType(), null, holder.getLine5()));
            result.setLine5(_transformedLine5);
            final String _transformedCity = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_cityType").getGenericType(), null, holder.getCity()));
            result.setCity(_transformedCity);
            final String _transformedCountry = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_countryType").getGenericType(), null, holder.getCountry()));
            result.setCountry(_transformedCountry);
            final String _transformedCountryCode = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_countryCodeType").getGenericType(), null, holder.getCountryCode()));
            result.setCountryCode(_transformedCountryCode);
            final String _transformedCountrySubDivisionCode = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_countrySubDivisionCodeType").getGenericType(), null, holder.getCountrySubDivisionCode()));
            result.setCountrySubDivisionCode(_transformedCountrySubDivisionCode);
            final String _transformedPostalCode = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_postalCodeType").getGenericType(), null, holder.getPostalCode()));
            result.setPostalCode(_transformedPostalCode);
            final String _transformedPostalCodeSuffix = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_postalCodeSuffixType").getGenericType(), null, holder.getPostalCodeSuffix()));
            result.setPostalCodeSuffix(_transformedPostalCodeSuffix);
            final String _transformedLat = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_latType").getGenericType(), null, holder.getLat()));
            result.setLat(_transformedLat);
            final String _transformedTag = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_tagType").getGenericType(), null, holder.getTag()));
            result.setTag(_transformedTag);
            final String _transformedNote = ((String) evaluateAndTransform(this.muleContext, event, PhysicalAddressExpressionHolder.class.getDeclaredField("_noteType").getGenericType(), null, holder.getNote()));
            result.setNote(_transformedNote);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
