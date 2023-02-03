package exps.utils.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Bean과 Map 사이 변환하여 주는 Util 
 * - Map to Bean
 * - Bean to Map
 * 
 */
@Slf4j
public class BeanConvertUtils {
    //map의 value을 bean에 넣어주는 메소드
	@SuppressWarnings("unchecked")
	public static void mapToBean(Map properties, Object bean) {
        if (properties == null) {
            return;
        }

        try {
            BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
            BeanUtils.populate(bean, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("BeanConvertUtils mapToBean error :: {}",e.getMessage());
        }

    }

    //bean의 value을 map에 넣어주는 메소드
    public static void beanToMap(Object bean, Map properties) {

        try {
            Map map = PropertyUtils.describe(bean);

            map.remove("class");
            properties.putAll(map);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("BeanConvertUtils beanToMap error :: {}",e.getMessage());
        }

    }
}