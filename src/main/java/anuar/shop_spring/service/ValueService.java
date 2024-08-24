package anuar.shop_spring.service;

import anuar.shop_spring.entity.Value;
import anuar.shop_spring.repository.ValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ValueService {

    private final ValueRepository valueRepository;

    public List<Value> getAllValues() {
        List<Value> values = new ArrayList<>();
        values.addAll(valueRepository.findAll());
        return values;
    }

    public Value getValueById(Long id) {
        return valueRepository.findById(id).orElseThrow(null);
    }

    public void saveValue(Value value) {
        valueRepository.save(value);
    }

    public void deleteValueById(Long id) {
        valueRepository.deleteById(id);
    }
}
