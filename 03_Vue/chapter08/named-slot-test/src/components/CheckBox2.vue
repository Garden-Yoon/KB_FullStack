<template>
  <div>
    <!-- icon이라는 이름의 슬롯을 받아옴 -->
    <slot name="icon"></slot>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- slot으로 부모에서 보낸 span을 전달받는다
      데이터가 없을 경우 기본값인 'Item'이 출력된다 -->
    <!-- label이라는 이름의 슬롯을 받아옴 -->
    <slot name="label">Item</slot>
  </div>
</template>

<script>
export default {
  name: 'CheckBox2',
  props: ['id', 'checked', 'label'], // 부모 컴포넌트로부터 받을 속성들
};
</script>
