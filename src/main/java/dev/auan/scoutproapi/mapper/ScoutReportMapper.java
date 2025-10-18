package dev.auan.scoutproapi.mapper;

import dev.auan.scoutproapi.dto.ScoutReportRequestDTO;
import dev.auan.scoutproapi.dto.ScoutReportResponseDTO;
import dev.auan.scoutproapi.model.ScoutReportModel;
import org.springframework.stereotype.Component;

@Component
public class ScoutReportMapper {

    public ScoutReportModel mapRequest(ScoutReportRequestDTO dto) {
        ScoutReportModel scoutReport = new ScoutReportModel();
        scoutReport.setReportDate(dto.getReportDate());
        scoutReport.setScoutName(dto.getScoutName());
        scoutReport.setPotentialScore(dto.getPotentialScore());
        scoutReport.setStregths(dto.getStregths());
        scoutReport.setWeaknesses(dto.getWeaknesses());
        scoutReport.setPlayer(dto.getPlayer());
        return scoutReport;
    }

    public ScoutReportRequestDTO mapRequest(ScoutReportModel scoutReport) {
        ScoutReportRequestDTO dto = new ScoutReportRequestDTO();
        dto.setReportDate(scoutReport.getReportDate());
        dto.setScoutName(scoutReport.getScoutName());
        dto.setPotentialScore(scoutReport.getPotentialScore());
        dto.setStregths(scoutReport.getStregths());
        dto.setWeaknesses(scoutReport.getWeaknesses());
        dto.setPlayer(scoutReport.getPlayer());
        return dto;
    }

    public ScoutReportResponseDTO mapResponse(ScoutReportModel scoutReport) {
        ScoutReportResponseDTO dto = new ScoutReportResponseDTO();
        dto.setId(scoutReport.getId());
        dto.setReportDate(scoutReport.getReportDate());
        dto.setScoutName(scoutReport.getScoutName());
        dto.setPotentialScore(scoutReport.getPotentialScore());
        dto.setStregths(scoutReport.getStregths());
        dto.setWeaknesses(scoutReport.getWeaknesses());
        return dto;
    }

    public ScoutReportModel mapResponse(ScoutReportResponseDTO dto) {
        ScoutReportModel scoutReport = new ScoutReportModel();
        scoutReport.setId(dto.getId());
        scoutReport.setReportDate(dto.getReportDate());
        scoutReport.setScoutName(dto.getScoutName());
        scoutReport.setPotentialScore(dto.getPotentialScore());
        scoutReport.setStregths(dto.getStregths());
        scoutReport.setWeaknesses(dto.getWeaknesses());
        return scoutReport;
    }

}
