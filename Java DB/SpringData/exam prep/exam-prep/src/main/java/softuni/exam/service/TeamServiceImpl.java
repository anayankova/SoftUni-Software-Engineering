package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.TeamSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.TEAMS_FILE_PATH;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final PictureService pictureService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
    }

    @Override
    
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        TeamSeedRootDto teamSeedRootDto = this.xmlParser.
                unmarshalFromFile(TEAMS_FILE_PATH, TeamSeedRootDto.class);
        teamSeedRootDto.getTeams()
                .forEach(t -> {
                    if(this.validatorUtil.isValid(t) && !t.getPicture().getUrl().equals("invalidURL")) {
                        if (this.teamRepository.findByName(t.getName()) == null) {
                            Team team = this.modelMapper.map(t, Team.class);
                            Picture picture = this.pictureService.getPictureByUrl(t.getPicture().getUrl());
                            team.setPicture(picture);
                            this.teamRepository.saveAndFlush(team);
                            sb.append("Successfully imported team");
                        }else {
                            sb.append("Already in DB");
                        }
                    } else {
                        sb.append("Invalid team");
                    }
                    sb.append(System.lineSeparator());
                });
       return sb.toString();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public Team getTeamByName(String name) {
        return this.teamRepository.findByName(name);
    }

}
