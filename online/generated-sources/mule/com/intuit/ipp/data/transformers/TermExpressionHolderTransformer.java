
package com.intuit.ipp.data.transformers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.AttachableRef;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ModificationMetaData;
import com.intuit.ipp.data.Term;
import com.intuit.ipp.data.holders.IntuitEntityExpressionHolder;
import com.intuit.ipp.data.holders.TermExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class TermExpressionHolderTransformer
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
        return (aClass == TermExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == TermExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {TermExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(TermExpressionHolder.class)});
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
        return Term.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Term.class);
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
        TermExpressionHolder holder = ((TermExpressionHolder) src);
        Term result = new Term();
        try {
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final Boolean _transformedActive = ((Boolean) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_activeType").getGenericType(), null, holder.getActive()));
            result.setActive(_transformedActive);
            final String _transformedType = ((String) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final BigDecimal _transformedDiscountPercent = ((BigDecimal) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_discountPercentType").getGenericType(), null, holder.getDiscountPercent()));
            result.setDiscountPercent(_transformedDiscountPercent);
            final Integer _transformedDueDays = ((Integer) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_dueDaysType").getGenericType(), null, holder.getDueDays()));
            result.setDueDays(_transformedDueDays);
            final Integer _transformedDiscountDays = ((Integer) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_discountDaysType").getGenericType(), null, holder.getDiscountDays()));
            result.setDiscountDays(_transformedDiscountDays);
            final BigInteger _transformedDayOfMonthDue = ((BigInteger) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_dayOfMonthDueType").getGenericType(), null, holder.getDayOfMonthDue()));
            result.setDayOfMonthDue(_transformedDayOfMonthDue);
            final BigInteger _transformedDueNextMonthDays = ((BigInteger) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_dueNextMonthDaysType").getGenericType(), null, holder.getDueNextMonthDays()));
            result.setDueNextMonthDays(_transformedDueNextMonthDays);
            final BigInteger _transformedDiscountDayOfMonth = ((BigInteger) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_discountDayOfMonthType").getGenericType(), null, holder.getDiscountDayOfMonth()));
            result.setDiscountDayOfMonth(_transformedDiscountDayOfMonth);
            final IntuitAnyType _transformedSalesTermEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, TermExpressionHolder.class.getDeclaredField("_salesTermExType").getGenericType(), null, holder.getSalesTermEx()));
            result.setSalesTermEx(_transformedSalesTermEx);
            final String _transformedId = ((String) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final String _transformedSyncToken = ((String) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_syncTokenType").getGenericType(), null, holder.getSyncToken()));
            result.setSyncToken(_transformedSyncToken);
            final ModificationMetaData _transformedMetaData = ((ModificationMetaData) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_metaDataType").getGenericType(), null, holder.getMetaData()));
            result.setMetaData(_transformedMetaData);
            final List<CustomField> _transformedCustomField = ((List<CustomField> ) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_customFieldType").getGenericType(), null, holder.getCustomField()));
            result.setCustomField(_transformedCustomField);
            final List<AttachableRef> _transformedAttachableRef = ((List<AttachableRef> ) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_attachableRefType").getGenericType(), null, holder.getAttachableRef()));
            result.setAttachableRef(_transformedAttachableRef);
            final String _transformedDomain = ((String) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_domainType").getGenericType(), null, holder.getDomain()));
            result.setDomain(_transformedDomain);
            final EntityStatusEnum _transformedStatus = ((EntityStatusEnum) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
            final Boolean _transformedSparse = ((Boolean) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_sparseType").getGenericType(), null, holder.getSparse()));
            result.setSparse(_transformedSparse);
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
