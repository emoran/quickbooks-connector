
package com.intuit.ipp.data.transformers;

import javax.annotation.Generated;
import com.intuit.ipp.data.CustomFieldTypeEnum;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class CustomFieldTypeEnumEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public CustomFieldTypeEnumEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(CustomFieldTypeEnum.class);
        setName("CustomFieldTypeEnumEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        CustomFieldTypeEnum result = null;
        result = Enum.valueOf(CustomFieldTypeEnum.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
