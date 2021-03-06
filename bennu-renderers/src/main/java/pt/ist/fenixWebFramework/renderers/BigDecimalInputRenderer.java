/**
 * Copyright © 2008 Instituto Superior Técnico
 *
 * This file is part of Bennu Renderers Framework.
 *
 * Bennu Renderers Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bennu Renderers Framework is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Bennu Renderers Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.ist.fenixWebFramework.renderers;

import java.math.BigDecimal;

import pt.ist.fenixWebFramework.renderers.components.converters.ConversionException;
import pt.ist.fenixWebFramework.renderers.components.converters.Converter;

/**
 * {@inheritDoc}
 * 
 * This renderer converts the value to a BigDecimal with its string constructor.
 * 
 * @author lepc
 */
public class BigDecimalInputRenderer extends NumberInputRenderer {

    @Override
    protected Converter getConverter() {
        return new BigDecimalNumberConverter();
    }

    private class BigDecimalNumberConverter extends Converter {

        @Override
        public Object convert(Class type, Object value) {
            final String numberText = ((String) value).trim().replace(',', '.');
            try {
                return numberText.length() == 0 ? null : new BigDecimal(numberText);
            } catch (NumberFormatException e) {
                throw new ConversionException("renderers.converter.bigdecimal", e, true, value);
            }
        }

    }
}
