
package org.mule.modules.quickbooks.online.transformers;

import java.math.BigInteger;
import javax.annotation.Generated;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class StringToBigIntegerTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int priorityWeighting = 1;

    public StringToBigIntegerTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(BigInteger.class);
        setName("StringToBigIntegerTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        try {
            return new BigInteger(((String) src));
        } catch (NumberFormatException e) {
            throw new TransformerException(MessageFactory.createStaticMessage(String.format("Could not parse %s to a big integer", src)), this, e);
        }
    }

    /**
     * Retrieves priorityWeighting
     * 
     */
    public int getPriorityWeighting() {
        return this.priorityWeighting;
    }

    /**
     * Sets priorityWeighting
     * 
     * @param value Value to set
     */
    public void setPriorityWeighting(int value) {
        this.priorityWeighting = value;
    }

}
