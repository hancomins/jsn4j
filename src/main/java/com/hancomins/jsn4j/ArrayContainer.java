package com.hancomins.jsn4j;


import java.util.Collection;
import java.util.List;

@SuppressWarnings({"UnusedReturnValue", "unused", "unchecked"})
public interface ArrayContainer extends ContainerValue, Iterable<ContainerValue>, ContainerFactoryProvidable, ValueWriter {



    ArrayContainer put(int index, Object value);

    default ArrayContainer put(int index, byte value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }

    default ArrayContainer put(int index, short value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(int index, byte[] value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }

    default ArrayContainer put(int index, int value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(int index, long value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(int index, float value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(int index, double value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(int index, boolean value) {
        return put(index, getContainerFactory().newPrimitive(value));
    }

    @SuppressWarnings("unchecked")
    ArrayContainer put(Object value);

    default ArrayContainer putAll(Collection<?> value) {
        if (value == null) {
            return this;
        }
        for (Object item : value) {
            put(item);
        }
        return this;
    }

    default ArrayContainer putAll(ArrayContainer arrayContainer) {
        if (arrayContainer == null) {
            return this;
        }
        int size = arrayContainer.size();
        for (int i = 0; i < size; i++) {
            ContainerValue value = arrayContainer.get(i);
            put(value);

        }
        return this;
    }


    default ArrayContainer put(char value) {
        return put(getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(byte value) {
        return put(getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(short value) {
        return put(getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(byte[] value) {
        return put(getContainerFactory().newPrimitive(value));
    }

    default ArrayContainer put(int value) {
        return put(getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(long value) {
        return put(getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(float value) {
        return put(getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(double value) {
        return put(getContainerFactory().newPrimitive(value));
    }
    default ArrayContainer put(boolean value) {
        return put(getContainerFactory().newPrimitive(value));
    }



    default ArrayContainer putNull() {
        return put(getContainerFactory().newPrimitive(null));
    }

    default ObjectContainer putCopy(ObjectContainer source) {
        ObjectContainer child = newAndPutObject();
        ContainerValues.copy(child, source);
        return child;
    }

    default ArrayContainer putCopy(ArrayContainer source) {
        ArrayContainer child = newAndPutArray();
        ContainerValues.copy(child, source);
        return child;
    }

    default boolean isEmpty() {
        return size() == 0;
    }


    /**
     * 객체를 생성하고, 키에 매핑하여 반환합니다.
     * @return 생성된 객체. ⚠️ 반환되는 객체는 자기 자신이 아닌 자식 객체입니다.
     */
    ObjectContainer newAndPutObject();

    /**
     * Array 타입의 객체를 생성하고, 키에 매핑하여 반환합니다.
     * @return 생성된 객체. ⚠️ 반환되는 객체는 자기 자신이 아닌 자식 객체입니다.
     */
    ArrayContainer newAndPutArray();



    int size();

    ContainerValue remove(int index);
    ContainerValue get(int index);

    default Object getRaw(int index) {
        ContainerValue value = get(index);
        if (value == null) {
            return null;
        }
        return value.raw();
    }




    /**
     * ContainerValue 직접 가져오기
     */

    default String getString(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return null;
        }
        if (value instanceof PrimitiveValue) {
            return value.toString();
        } else {
            return String.valueOf(value);
        }
    }

    default String getString(int index, String defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return value.toString();
        } else {
            return defaultValue;
        }
    }

    // ---- 편의 메서드 (불리언) ----

    default boolean getBoolean(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return false;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asBoolean();
        } else {
            return false;
        }

    }
    default boolean getBoolean(int index, boolean defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asBooleanOr(defaultValue);
        } else {
            return defaultValue;
        }
    }

    // ---- 숫자형 ----

    default short getShort(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return Short.MIN_VALUE;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asShort();
        } else {
            return Short.MIN_VALUE;
        }
    }

    default short getShort(int index, short defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asShortOr(defaultValue);
        } else {
            return defaultValue;
        }
    }

    default int getInt(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return Integer.MIN_VALUE;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asInt();
        } else {
            return Integer.MIN_VALUE;
        }
    }
    default int getInt(int index, int defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asIntOr(defaultValue);
        } else {
            return defaultValue;
        }
    }

    default long getLong(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return Long.MIN_VALUE;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asLong();
        } else {
            return Long.MIN_VALUE;
        }
    }
    default long getLong(int index, long defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asLongOr(defaultValue);
        } else {
            return defaultValue;
        }
    }

    default float getFloat(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return Float.NaN;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asFloat();
        } else {
            return Float.NaN;
        }
    }
    default float getFloat(int index, float defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asFloatOr(defaultValue);
        } else {
            return defaultValue;
        }
    }

    default double getDouble(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return Double.NaN;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asDouble();
        } else {
            return Double.NaN;
        }
    }

    default double getDouble(int index, double defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asDoubleOr(defaultValue);
        } else {
            return defaultValue;
        }
    }

    // ---- 바이트 배열 ----

    default byte[] getByteArray(int index) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return null;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asByteArray();
        } else {
            return null;
        }
    }

    default byte[] getByteArray(int index, byte[] defaultValue) {
        ContainerValue value = get(index);
        if (value == null || value.isNull()) {
            return defaultValue;
        }
        if (value instanceof PrimitiveValue) {
            return ((PrimitiveValue) value).asByteArrayOr(defaultValue);
        } else {
            return defaultValue;
        }
    }

    // ---- 중첩 오브젝트 / 배열 ----

    default ObjectContainer getObject(int index) {
        ContainerValue value = get(index);
        if (value instanceof ObjectContainer) {
            return (ObjectContainer) value;
        } else {
            return null;
        }
    }

    default ObjectContainer getObject(int index, ObjectContainer defaultValue) {
        ContainerValue value = get(index);
        if (value instanceof ObjectContainer) {
            return (ObjectContainer) value;
        } else {
            return defaultValue;
        }
    }

    default ObjectContainer getObjectOrNew(int index) {
        ContainerValue value = get(index);
        if (value instanceof ObjectContainer) {
            return (ObjectContainer) value;
        } else {
            ObjectContainer newObject = newAndPutObject();
            put(index, newObject);
            return newObject;
        }
    }


    default ArrayContainer getArray(int index) {
        ContainerValue value = get(index);
        if (value instanceof ArrayContainer) {
            return (ArrayContainer) value;
        } else {
            return null;
        }
    }

    default ArrayContainer getArray(int index, ArrayContainer defaultValue) {
        ContainerValue value = get(index);
        if (value instanceof ArrayContainer) {
            return (ArrayContainer) value;
        } else {
            return defaultValue;
        }
    }

    default ArrayContainer getArrayOrNew(int index) {
        ContainerValue value = get(index);
        if (value instanceof ArrayContainer) {
            return (ArrayContainer) value;
        } else {
            ArrayContainer newArray = newAndPutArray();
            put(index, newArray);
            return newArray;
        }
    }


    @Override
    default Object raw() {
        return this;
    }

    default List<Object> toRawList() {
        int size = size();
        List<Object> list = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ContainerValue value = get(i);
            if (value != null) {
                list.add(value.raw());
            } if(value instanceof ArrayContainer) {
                list.add(((ArrayContainer) value).toRawList());
            } else if(value instanceof ObjectContainer) {
                list.add(((ObjectContainer) value).toRawMap());
            }
            else {
                list.add(null);
            }
        }
        return list;
    }

    default List<ContainerValue> toList() {
        int size = size();
        List<ContainerValue> list = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ContainerValue value = get(i);
            list.add(value);
        }
        return list;
    }

    void clear();


    default void merge(ArrayContainer source) {
        ContainerValues.merge(this, source);
    }

    default ArrayContainer concat(ArrayContainer source) {
        return ContainerValues.concat(this, source).asArray();
    }

    default ArrayContainer convertTo(JsonLibrary jsonLibrary) {
        ContainerFactory containerFactory = Jsn4j.getContainerFactory(jsonLibrary);
        if(containerFactory == getContainerFactory()) {
            return this;
        } else {
            ArrayContainer newContainer = containerFactory.newArray();
            ContainerValues.copy(newContainer, this);
            return newContainer;
        }
    }





}

