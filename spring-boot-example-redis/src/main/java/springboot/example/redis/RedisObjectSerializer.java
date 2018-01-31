package springboot.example.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer<Object> {
	
	private Converter<Object, byte[]> serializer = new SerializingConverter();
	private Converter<byte[], Object> deserializer = new DeserializingConverter();
	
	private static final byte[] EMPTY_ARRAY = new byte[0];
	
	@Override
	public byte[] serialize(Object t) throws SerializationException {
		if (t == null) {
			return EMPTY_ARRAY;
		}
		return serializer.convert(t);
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if(bytes == null) {
			return null;
		}
		
		return deserializer.convert(bytes);
	}

}
