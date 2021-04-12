package com.bizns.bizneyland.service;

import com.bizns.bizneyland.domain.client.Client;
import com.bizns.bizneyland.domain.client.ClientRepository;
import com.bizns.bizneyland.web.dto.ClientRequestDto;
import com.bizns.bizneyland.web.dto.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public Client save(ClientRequestDto requestDto) {
        return repository.save(requestDto.toEntity());
    }

    public Client findById(Long clientSeq) {
        return repository.findById(clientSeq)
                .orElseThrow(() -> new IllegalArgumentException("해당 업체가 없습니다. seq=" + clientSeq));
    }

    public boolean isExist(String name) {
        Client entity = repository.findByCompanyName(name);

        return entity != null ? true: false;
    }

    /**
     * 이름으로 조회 후 수정
     */
    public Client updateByName(String name, ClientRequestDto dto) {
        Client entity = repository.findByCompanyName(name);
        entity.update(dto);

        return entity;
    }

    public List<Client> findAll() {
        return repository.findAllDesc();
    }
}
