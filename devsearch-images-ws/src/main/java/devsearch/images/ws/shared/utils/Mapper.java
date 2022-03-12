package devsearch.images.ws.shared.utils;

public interface Mapper {

    public <D> D map(Object source, Class<D> destinationType);
}
