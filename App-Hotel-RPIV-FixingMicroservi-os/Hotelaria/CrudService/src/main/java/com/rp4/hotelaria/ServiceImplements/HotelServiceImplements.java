package com.rp4.hotelaria.ServiceImplements;

import com.rp4.hotelaria.ProducerMensagem.HotelProducer;
import com.rp4.hotelaria.interfaces.IHotelService;
import com.rp4.hotelaria.model.Hotel;
import com.rp4.hotelaria.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class HotelServiceImplements implements IHotelService {

    private HotelRepository hotelRepository;
    private HotelProducer hotelProducer;

    @Autowired
    public HotelServiceImplements(HotelRepository hotelR, HotelProducer hotelProducer) {
        this.hotelRepository = hotelR;
        this.hotelProducer = hotelProducer;

    }

    @Override
    @Transactional
    public void salvarHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        hotelProducer.producerMensagem(hotel);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findHotelByIdHotel(id);

    }

    @Override
    public Hotel atualizarHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void excluirHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<Hotel> pegarTodosHoteis() {
        return hotelRepository.findAll();
    }


}
