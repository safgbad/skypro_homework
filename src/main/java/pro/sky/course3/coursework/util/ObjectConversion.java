package pro.sky.course3.coursework.util;

import org.apache.commons.lang3.StringUtils;
import pro.sky.course3.coursework.dto.ApiOperationDTO;
import pro.sky.course3.coursework.dto.ApiPairOfSocksDTO;
import pro.sky.course3.coursework.exceptions.InvalidInputException;
import pro.sky.course3.coursework.model.Operation;
import pro.sky.course3.coursework.model.PairOfSocks;
import pro.sky.course3.coursework.model.enums.Color;
import pro.sky.course3.coursework.model.enums.OperationType;
import pro.sky.course3.coursework.model.enums.Size;

import java.util.List;
import java.util.Map;

public class ObjectConversion {
    public static PairOfSocks getPairOfSocksFromDTO(ApiPairOfSocksDTO apiPairOfSocksDTO) throws InvalidInputException {
        Color color = getColorFromString(apiPairOfSocksDTO.getColor());
        Size size = Size.getSize(apiPairOfSocksDTO.getSize());

        ValueCheck.checkCottonPart(apiPairOfSocksDTO.getCottonPart(), false);
        int cottonPart = apiPairOfSocksDTO.getCottonPart();

        return new PairOfSocks(color, size, cottonPart);
    }

    public static Color getColorFromString(String color) throws InvalidInputException {
        if (color == null) {
            throw new InvalidInputException("Color is not specified");
        }
        try {
            return Color.valueOf(StringUtils.upperCase(color));
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("This color (" + color + ") " +
                    "is not available in the store");
        }
    }

    public static OperationType getOperationTypeFromString(String operationType) throws InvalidInputException {
        if (operationType == null) {
            throw new InvalidInputException("Operation type is not specified");
        }
        try {
            return OperationType.valueOf(StringUtils.upperCase(operationType));
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("This operation type (" + operationType + ") " +
                    "is not available");
        }
    }

    private static ApiPairOfSocksDTO convertPairOfSocksToDTO(PairOfSocks pairOfSocks, Integer quantity) {
        return new ApiPairOfSocksDTO(
                pairOfSocks.getColor().getValue(),
                pairOfSocks.getSize().getLowerSize(),
                pairOfSocks.getCottonPart(),
                quantity);
    }

    public static List<ApiPairOfSocksDTO> convertPairsOfSocksToListOfDTO(Map<PairOfSocks, Integer> socks) {
        return socks.entrySet().stream()
                .map(entry -> convertPairOfSocksToDTO(entry.getKey(), entry.getValue()))
                .toList();
    }

    public static List<ApiOperationDTO> convertOperationsToListOfDTO(Map<Integer, Operation> operations) {
        return operations.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .map(operation -> new ApiOperationDTO(
                        operation.getId(),
                        operation.getOperationType().toString(),
                        operation.getDateTime().format(ApiOperationDTO.formatter),
                        convertPairOfSocksToDTO(operation.getSocks(), operation.getQuantity())))
                .toList();
    }
}
