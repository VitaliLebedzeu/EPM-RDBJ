package functional;

import java.util.List;

@FunctionalInterface
public interface InfoHarvester<R> {

    String harvest(List<R> string);
}
